# Generated by Django 4.1 on 2022-08-06 18:56

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0003_empresa_cliente_list_empresa_empleado_list'),
    ]

    operations = [
        migrations.AlterField(
            model_name='producto',
            name='precioUnitario',
            field=models.FloatField(blank=True),
        ),
    ]
