import { Routes } from '@angular/router';
import { Inicio } from './ComponentesPublico/inicio/inicio';
import { Login } from './ComponentesPublico/login/login';
import { Registro } from './ComponentesPublico/registro/registro';
import { InicioCliente } from './Clientes/inicio-cliente/inicio-cliente';
import { InicioAdmin } from './Administrador/inicio-admin/inicio-admin';
import { InicioEmpleado } from './Empleado/inicio-empleado/inicio-empleado';


export const routes: Routes = [

    //Rutas Compartidas
    {path:"inicio", component: Inicio},
    {path:"login", component: Login},
    {path:'', redirectTo: '/inicio', pathMatch: 'full'},
    {path: "registro", component: Registro},


    //rutas del cliente
    {path: "inicioCliente", component: InicioCliente},


    //Rutas del adminsitrador
    {path: "inicioAdmin", component: InicioAdmin},


    //
    {path:"inicioEmpleado", component: InicioEmpleado}

];
