# Generated by Django 4.1 on 2022-08-07 19:20

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0013_remove_detallefactura_valortotal'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='detallefactura',
            name='factura',
        ),
        migrations.AddField(
            model_name='factura',
            name='detalle_list',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, related_name='factura', to='factura.detallefactura'),
        ),
    ]