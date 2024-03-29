from django.urls import path
from django.contrib import admin

import factura.views
from factura import views

app_name = 'sistemafactura'

urlpatterns = [

    path('admin/', admin.site.urls, name='administracion'),
    path('sesion', views.sesion_iniciada, name='sesion_iniciada'),
    path('datos_empresa', views.datos_empresa, name='empresa'),
    path('facturas', views.facturas_hechas, name='facturas'),
    path('facturas/<int:factura_id>', views.factura_detalle, name='factura-id'),
    path('clientes', views.clientes, name='clientes'),
    path('productos', views.productos, name='productos'),
    path('inventario', views.inventario, name='inventario'),
    path('empleados', views.empleados, name='empleados'),
    path('logout', views.logout_request, name='salir'),
    path('agregar_producto', views.agregar_producto, name='agregar-producto'),
    path('modificar_producto/<id>/', views.modificar_producto, name='modificar-producto'),
    path('eliminar_producto/<id>/', views.eliminar_producto, name='eliminar-producto'),
    path('agregar_cliente', views.agregar_cliente, name='agregar-cliente'),
    path('modificar_cliente/<id>/', views.modificar_cliente, name='modificar-cliente'),
    path('eliminar_cliente/<id>/', views.eliminar_cliente, name='eliminar-cliente'),
    path('crear_factura', views.agregar_factura, name='crear-factura'),
    path('agregar_empleado', views.agregar_empleado, name='agregar-empleado'),
    path('modificar_empleado/<id>/', views.modificar_empleado, name='modificar-empleado'),
    path('eliminar_empleado/<id>/', views.eliminar_empleado, name='eliminar-empleado'),
    path('api', views.api_marvel, name='api-marvel'),

]


