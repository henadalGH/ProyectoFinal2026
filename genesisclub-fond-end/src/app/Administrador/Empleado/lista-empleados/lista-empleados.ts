import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderAdmin } from "../../header-admin/header-admin";
import { Router, RouterLink } from '@angular/router';
import { EmpleadoServicio } from '../../ServicioAdmin/empleado-servicio';

@Component({
  selector: 'app-lista-empleados',
  standalone: true,
  imports: [CommonModule, HeaderAdmin, RouterLink],
  templateUrl: './lista-empleados.html',
  styleUrls: ['./lista-empleados.css']
})
export class ListaEmpleados implements OnInit {

  empleado: any[] = [];
  cargando = true;

  constructor(
    private empleadoServicio: EmpleadoServicio,
    private router: Router,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.obtenerEmpleado();
  }

  obtenerEmpleado(): void {
    this.empleadoServicio.obtenerEmpleado().subscribe({
      next: (respuesta: any) => {
        this.empleado = [...respuesta]; // 👈 importante
        this.cargando = false;
        this.cd.detectChanges(); // 👈 importante
        console.log('llegó', respuesta);
      },
      error: () => {
        this.cargando = false;
        this.cd.detectChanges(); // 👈 también acá
      }
    });
  }

  verEmplado(id: number) {
    this.router.navigate(['/verEmpleado', id]);
  }
}