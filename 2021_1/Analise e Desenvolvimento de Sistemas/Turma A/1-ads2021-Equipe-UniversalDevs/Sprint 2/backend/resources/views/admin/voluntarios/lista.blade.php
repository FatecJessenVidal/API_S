@extends('layouts.painel')
@section('pre-assets')
@endsection
@section('painel')
<section class="content-header">
    <h1 class="col-6">Voluntarios</h1>
    <div class="clearfix"></div>
</section>


<section class="col-12">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
               
                <div class="card-tools float-left">
                    <a href="{{ route('admin.voluntarios.novo') }}" class="btn btn-warning btn-xs"><i class="fas fa-plus"></i> Cadastrar</a>
                </div>
            </div>

            <!-- /.card-header -->
            <div class="card-body table-responsive p-0">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Tipo</th>
                                <th class=" text-right">Ações</th>

                            </tr>
                        </thead>
                        <tbody>
                            @foreach($voluntarios as $voluntario)
                                <tr>
                                    <td>{{ $voluntario->nome }}</td>

                                    <td>{{ $voluntario->tipo }}</td>
                                    <td class="project-actions text-right">
                                        <a class="btn btn-info btn-sm"
                                            href="{{ route('admin.voluntarios.editar', $voluntario->id) }}">
                                            <i class="fas fa-pencil-alt">
                                            </i>
                                        </a>
                                        <!-- <a class="btn btn-info btn-sm" href="">
                                <i class="fas fa-eye">
                                </i>
                            </a> -->
                                        <a class="btn btn-danger btn-sm"
                                            href="{{ route('admin.voluntarios.delete', $voluntario->id) }}">
                                            <i class="fas fa-trash">
                                            </i>
                                        </a>
                                    </td>
                                </tr>
                            @endforeach
                        </tbody>
                    </table>


            </div>
            <!-- /.card-body -->
        </div>
        <!-- /.card -->

    </div>

</section>


@endsection

@section('pos-script')
<script type="text/javascript">

</script>
@endsection