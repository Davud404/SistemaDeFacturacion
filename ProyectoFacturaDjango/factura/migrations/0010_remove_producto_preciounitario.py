# Generated by Django 4.1 on 2022-08-07 18:27

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0009_factura_total_inventario_en_stock'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='producto',
            name='precioUnitario',
        ),
    ]
