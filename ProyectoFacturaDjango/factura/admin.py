from django.contrib import admin
from factura.models import Empresa, Empleado, Cliente, Factura, DetalleFactura, Producto, Inventario

class ProductoAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'precio_unitario', 'stock')


class EmpleadoAdmin(admin.ModelAdmin):
    list_display = ('empleado', 'cedula', 'cargo')


class ClienteAdmin(admin.ModelAdmin):
    list_display = ('cliente', 'cedula')


class DetalleFacturaAdmin(admin.ModelAdmin):
    list_display = ('cantidad', 'producto', 'valor_total')


class EmpresaAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'ruc', 'porcentajeIva')


class FacturaAdmin(admin.ModelAdmin):
    list_display = ('numero_factura', 'subtotal', 'monto_iva', 'total')

admin.site.register(Empresa, EmpresaAdmin)
admin.site.register(Empleado, EmpleadoAdmin)
admin.site.register(Cliente, ClienteAdmin)
admin.site.register(Factura, FacturaAdmin)
admin.site.register(DetalleFactura, DetalleFacturaAdmin)
admin.site.register(Producto, ProductoAdmin)
admin.site.register(Inventario)