# Generated by Django 4.1 on 2022-08-06 18:45

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('factura', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='inventario',
            name='empresa',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='factura.empresa'),
        ),
    ]
