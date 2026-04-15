import { Component, OnInit } from '@angular/core';
import { RouterLink } from "@angular/router";
import { EmpleadoServiceAdmin } from '../../ServiciosAdmin/empleado-service-admin';

@Component({
  selector: 'app-lista-empleado',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './lista-empleado.html',
  styleUrl: './lista-empleado.css',
})
export class ListaEmpleado implements OnInit{

  constructor(private empleadoService: EmpleadoServiceAdmin) { }

  empleados: any[] = [];

  ngOnInit() {
    this.obtenerEmpleados();
  }

  obtenerEmpleados(){

    this.empleadoService.ObteneEmpleados().subscribe(
      {
        next: (repuesta: any)=> {
          this.empleados = repuesta;
        }
      })

  }
}
