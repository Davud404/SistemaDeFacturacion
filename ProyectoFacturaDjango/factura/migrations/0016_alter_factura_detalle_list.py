# Generated by Django 4.1 on 2022-08-07 19:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0015_remove_factura_detalle_list_factura_detalle_list'),
    ]

    operations = [
        migrations.AlterField(
            model_name='factura',
            name='detalle_list',
            field=models.ManyToManyField(blank=True, related_name='factura', to='factura.detallefactura'),
        ),
    ]
