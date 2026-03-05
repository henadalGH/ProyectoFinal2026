import { Routes } from '@angular/router';
import { Inicio } from './ComponentesPublico/inicio/inicio';
import { Login } from './ComponentesPublico/login/login';
import { Registro } from './ComponentesPublico/registro/registro';
import { InicioCliente } from './Clientes/inicio-cliente/inicio-cliente';
import { InicioAdmin } from './Administrador/inicio-admin/inicio-admin';
import { InicioEmpleado } from './Empleado/inicio-empleado/inicio-empleado';
import { HeaderCliente } from './Clientes/header-cliente/header-cliente';
import { HeaderAdmin } from './Administrador/header-admin/header-admin';
import { ListaEmpleados } from './Administrador/Empleado/lista-empleados/lista-empleados';
import { VerEmpleado } from './Administrador/Empleado/ver-empleado/ver-empleado';


export const routes: Routes = [

    //Rutas Compartidas
    {path:"inicio", component: Inicio},
    {path:"login", component: Login},
    {path:'', redirectTo: '/inicio', pathMatch: 'full'},
    {path: "registro", component: Registro},


    //rutas del cliente
    {path: "inicioCliente", component: InicioCliente},
    {path: "headerCliente", component: HeaderCliente},

    //Rutas del adminsitrador
    {path: "inicioAdmin", component: InicioAdmin},
    {path: "headerAdmin", component: HeaderAdmin},
    {path: "listaEmpleados", component: ListaEmpleados},


    //Rutas empleado
    {path:"inicioEmpleado", component: InicioEmpleado},
    {path:"verEmpleado/:id", component: VerEmpleado}

];
