# Generated by Django 4.1 on 2022-08-12 21:40

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0020_producto_detalle'),
    ]

    operations = [
        migrations.AddField(
            model_name='factura',
            name='sub_total',
            field=models.FloatField(editable=False, null=True),
        ),
    ]