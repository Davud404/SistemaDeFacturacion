# Generated by Django 4.1 on 2022-08-12 22:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0032_alter_factura_sub_total'),
    ]

    operations = [
        migrations.AlterField(
            model_name='factura',
            name='sub_total',
            field=models.FloatField(default=0, editable=False),
        ),
    ]
