# Generated by Django 4.1 on 2022-08-07 17:30

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0006_alter_factura_monto_iva_alter_factura_subtotal'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='factura',
            name='id',
        ),
        migrations.AlterField(
            model_name='factura',
            name='numero_factura',
            field=models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='No. '),
        ),
    ]
