# Generated by Django 4.1 on 2022-08-10 02:27

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0018_remove_factura_monto_iva'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='factura',
            name='total',
        ),
    ]