# Generated by Django 4.1 on 2022-08-12 22:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0028_factura_montoiva_factura_sub_total_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='factura',
            name='montoiva',
            field=models.FloatField(null=True),
        ),
        migrations.AlterField(
            model_name='factura',
            name='sub_total',
            field=models.FloatField(null=True),
        ),
        migrations.AlterField(
            model_name='factura',
            name='valor_total',
            field=models.FloatField(null=True),
        ),
    ]
