from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.forms import AuthenticationForm
from django.shortcuts import render, redirect, get_object_or_404
from django.contrib import messages
from factura.forms import ProductoForm, ClienteForm, FacturaForm, DetalleForm

from factura.models import Factura, Cliente, Producto, Inventario, DetalleFactura


def index(request):
    return render(request, 'factura/index.html', {})


def sesion_iniciada(request):
    return render(request, 'factura/inicio.html', {})


def facturas_hechas(request):
    facturas = Factura.objects.all()
    context={
        'facturas': facturas,
    }
    return render(request, 'factura/facturas_hechas.html', context)


def clientes(request):
    clientes = Cliente.objects.all()
    context = {
        'clientes': clientes,
    }
    return render(request, 'factura/clientes.html', context)


def productos(request):
    productos = Producto.objects.all()
    context={
        'productos': productos,
    }
    return render(request, 'factura/productos.html', context)


def factura_detalle(request, factura_id):
    factura = get_object_or_404(Factura, pk=factura_id)
    context = {
        'factura': factura,
    }
    return render(request, 'factura/detalle_factura.html', context)


def inventario(request):
    productos = Producto.objects.all()
    context = {
        'productos': productos,
    }
    return render(request, 'factura/inventario.html', context)


def agregar_producto(request):
    context = {
        'form': ProductoForm()
    }

    if request.method == 'POST':
        formulario  = ProductoForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect("sistemafactura:productos")
        else:
            context["form"]=formulario

    return render(request, 'factura/agregar_producto.html', context)


def modificar_producto(request, id):
    producto = get_object_or_404(Producto, id=id)

    context = {
        'form': ProductoForm(instance=producto)
    }
    if request.method == 'POST':
        formulario = ProductoForm(data=request.POST, instance=producto)
        if formulario.is_valid():
            formulario.save()
            return redirect("sistemafactura:productos")
        else:
            context["form"] = formulario
    return render(request, 'factura/modificar_producto.html', context)


def eliminar_producto(request, id):
    producto = get_object_or_404(Producto, id=id)
    producto.delete()
    return redirect("sistemafactura:productos")


def agregar_cliente(request):
    context = {
        'form': ClienteForm()
    }

    if request.method == 'POST':
        formulario = ClienteForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect("sistemafactura:clientes")
        else:
            context["form"]=formulario

    return render(request, 'factura/agregar_cliente.html', context)


def modificar_cliente(request, id):
    cliente = get_object_or_404(Cliente, id=id)

    context = {
        'form': ClienteForm(instance=cliente)
    }
    if request.method == 'POST':
        formulario = ClienteForm(data=request.POST, instance=cliente)
        if formulario.is_valid():
            formulario.save()
            return redirect("sistemafactura:clientes")
        else:
            context["form"] = formulario
    return render(request, 'factura/modificar_cliente.html', context)


def eliminar_cliente(request, id):
    cliente = get_object_or_404(Cliente, id=id)
    cliente.delete()
    return redirect("sistemafactura:clientes")


def agregar_factura(request):
    context = {
        'form': FacturaForm(),
    }

    if request.method == 'POST':
        formulario = FacturaForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect("sistemafactura:facturas")
        else:
            context["form"]=formulario

    return render(request, 'factura/agregar_factura.html', context)


def login_request(request):
    if request.method == "POST":
        form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            usuario = form.cleaned_data.get('username')
            contrasenia = form.cleaned_data.get('password')
            user = authenticate(username=usuario, password=contrasenia)
            if user is not None:
                login(request, user)
                return redirect("sistema/sesion")
            else:
                messages.error(request, 'Usuario o contraseña equivocada')
        else:
            messages.error(request, 'Usuario o contraseña equivocada')

    form = AuthenticationForm()
    return render(request, 'factura/index.html', {"form": form})


def logout_request(request):
    logout(request)
    messages.info(request, "Saliste de la sesión")
    return redirect("index")


def handle_not_found(request, exception):
    return render(request, 'factura/pag_no_encontrada.html')