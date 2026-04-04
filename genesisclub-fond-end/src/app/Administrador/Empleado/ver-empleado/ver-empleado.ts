import { Component, OnInit } from '@angular/core';
import { EmpleadoServicio } from '../../ServicioAdmin/empleado-servicio';
import { ActivatedRoute } from '@angular/router';
import { HeaderAdmin } from "../../header-admin/header-admin";

@Component({
  selector: 'app-ver-empleado',
  templateUrl: './ver-empleado.html',
  styleUrl: './ver-empleado.css',
  imports: [HeaderAdmin],
})
export class VerEmpleado implements OnInit {

  empleado: any;

  constructor(
    private empleadoServi: EmpleadoServicio,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.obtenerEmpleado(id);
  }

  obtenerEmpleado(id: number){
    this.empleadoServi.verEmpleado(id).subscribe({
      next: (respuesta: any) => {
        this.empleado = respuesta;
      },
      error: (err) => {
        console.error('Error al obtener empleado', err);
      }
    });
  }

}