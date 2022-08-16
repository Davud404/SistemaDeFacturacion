from django import forms
from factura.models import Producto, Cliente, Factura, DetalleFactura, Empleado


class ProductoForm(forms.ModelForm):

    class Meta:
        model = Producto
        fields = '__all__'


class ClienteForm(forms.ModelForm):

    class Meta:
        model = Cliente
        fields = '__all__'


class FacturaForm(forms.ModelForm):

    class Meta:
        model = Factura
        fields = '__all__'


class DetalleForm(forms.ModelForm):

    class Meta:
        model = DetalleFactura
        fields = '__all__'


class EmpleadoForm(forms.ModelForm):

    class Meta:
        model = Empleado
        fields = '__all__'

