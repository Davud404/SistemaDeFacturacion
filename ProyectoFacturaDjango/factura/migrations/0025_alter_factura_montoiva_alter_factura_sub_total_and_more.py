# Generated by Django 4.1 on 2022-08-12 22:08

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0024_factura_sub_total'),
    ]

    operations = [
        migrations.AlterField(
            model_name='factura',
            name='montoiva',
            field=models.FloatField(editable=False),
        ),
        migrations.AlterField(
            model_name='factura',
            name='sub_total',
            field=models.FloatField(editable=False),
        ),
        migrations.AlterField(
            model_name='factura',
            name='valor_total',
            field=models.FloatField(editable=False),
        ),
    ]
