# Generated by Django 3.0.7 on 2020-06-18 00:05

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('gantt', '0003_auto_20200603_2345'),
    ]

    operations = [
        migrations.AlterField(
            model_name='tb_pessoa',
            name='pes_id',
            field=models.IntegerField(primary_key=True, serialize=False, verbose_name='id'),
        ),
        migrations.AlterField(
            model_name='tb_projeto',
            name='prj_id',
            field=models.IntegerField(primary_key=True, serialize=False, verbose_name='id'),
        ),
        migrations.AlterField(
            model_name='tb_tarefa',
            name='trf_id',
            field=models.IntegerField(primary_key=True, serialize=False, verbose_name='id'),
        ),
        migrations.CreateModel(
            name='tb_pes_Trf',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('fk_pes_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='gantt.tb_Pessoa')),
                ('fk_prj_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='gantt.tb_Projeto')),
                ('fk_trf_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='gantt.tb_Tarefa')),
            ],
            options={
                'unique_together': {('fk_pes_id', 'fk_trf_id', 'fk_prj_id')},
            },
        ),
    ]
