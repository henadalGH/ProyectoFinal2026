import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderAdmin } from "../../header-admin/header-admin";
import { Router } from '@angular/router';
import { EmpleadoServicio } from '../../ServicioAdmin/empleado-servicio';

@Component({
  selector: 'app-lista-empleados',
  standalone: true,
  imports: [CommonModule, HeaderAdmin],
  templateUrl: './lista-empleados.html',
  styleUrls: ['./lista-empleados.css']
})
export class ListaEmpleados implements OnInit {

  empleado: any[] = [];

  constructor(private empleadoServicio: EmpleadoServicio,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerEmpleado();
  }

  obtenerEmpleado(): void {
    this.empleadoServicio.obtenerEmpleado().subscribe({
      next: (respuesta: any) => {
        console.log('DATA BACKEND =>', respuesta); 
        this.empleado = respuesta; 
      },
      error: (err) => console.error(err)
    });
  }

  verEmplado(id: number) {
    this.router.navigate(['/verEmpleado',id]);
  }
}