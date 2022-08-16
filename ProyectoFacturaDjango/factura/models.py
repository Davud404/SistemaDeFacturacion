from django.db import models


class Persona(models.Model):
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    cedula = models.CharField(max_length=10)
    direccion = models.CharField(max_length=50, blank=True)
    telefono = models.CharField(max_length=10, blank=True)
    correo = models.CharField(max_length=25, blank=True)


class Empleado(Persona):
    cargo = models.CharField(max_length=20)

    def __str__(self):
        return self.nombre +" "+ self.apellido


class Cliente(Persona):
    def __str__(self):
        return self.nombre +" "+ self.apellido


class Empresa(models.Model):
    porcentajeIva = models.IntegerField()
    utilidad = models.IntegerField()
    nombre = models.CharField(max_length=50)
    ruc = models.CharField(max_length=13)
    telefono = models.CharField(max_length=10)
    correo = models.CharField(max_length=25)

    empleado_list = models.ManyToManyField('Empleado', blank=True, related_name='empresa')
    cliente_list = models.ManyToManyField('Cliente', blank=True, related_name='empresa')

    def __str__(self):
        return self.nombre


class Factura(models.Model):
    numero_factura = models.BigAutoField(primary_key=True, auto_created=True, serialize=False, verbose_name="No. ")
    monto_iva = models.FloatField(blank=True)
    fecha = models.DateField('Fecha', blank=False, null=False)
    sub_total = models.FloatField(editable=False, null=False, default=0)
    montoiva = models.FloatField(editable=False, null=False, default=0)
    valor_total = models.FloatField(editable=False, null=False, default=0)

    empresa = models.ForeignKey('Empresa', null=True, blank=True, on_delete=models.CASCADE, related_name='factura_list')
    cliente = models.ForeignKey('Cliente', null=True, blank=True, on_delete=models.CASCADE)
    detalle_list = models.ManyToManyField('DetalleFactura', blank=True, related_name='factura')

    def subtotal(self):
        subtotal = 0
        aux = self.detalle_list.all()
        for detalle in aux:
            aux2 = detalle.valor_total
            subtotal = aux2 + subtotal
            self.sub_total = subtotal
        return subtotal

    def monto_iva(self):
        monto_iva = self.subtotal() * (self.empresa.porcentajeIva/100)
        self.montoiva = monto_iva
        return monto_iva

    def total(self):
        total = self.monto_iva() + self.subtotal()
        self.valor_total = total
        return total
    
    def __str__(self):
        return "Factura No. "+str(self.numero_factura)


class DetalleFactura(models.Model):
    cantidad = models.IntegerField()
    producto = models.ForeignKey('Producto', null=True, blank=True, on_delete=models.CASCADE)

    @property
    def valor_total(self):
        valorTotal = self.cantidad * self.producto.precio_unitario
        return valorTotal

    @property
    def disminuir_stock(self):
        self.producto.stock = self.producto.stock - self.cantidad
        return self.producto.stock

    def __str__(self):
        return self.producto.nombre + " x " + str(self.cantidad)


class Producto(models.Model):
    nombre = models.CharField(max_length=50)
    detalle = models.CharField(max_length=100, blank=True, null=True)
    precioCompra = models.FloatField()
    stock = models.IntegerField()

    @property
    def precio_unitario(self):
        precio_unitario = self.precioCompra + (self.precioCompra * (25 / 100))
        return precio_unitario

    def __str__(self):
        return self.nombre


class Inventario(models.Model):
    producto_list = models.ManyToManyField('Producto', blank=True, related_name='inventario')
    empresa = models.ForeignKey('Empresa', null=True, blank=True, on_delete=models.CASCADE)

    def __str__(self):
        return "inventario"

