# Generated by Django 4.1 on 2022-08-09 22:50

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0016_alter_factura_detalle_list'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='factura',
            name='subtotal',
        ),
    ]
