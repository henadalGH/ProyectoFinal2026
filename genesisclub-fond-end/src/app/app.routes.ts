import { Routes } from '@angular/router';
import { Inicio } from './ComponentesPublico/inicio/inicio';
import { Login } from './ComponentesPublico/login/login';
import { RegistroCliente } from './ComponentesPublico/registro-cliente/registro-cliente';
import { InicioCliente } from './Cliente/inicio-cliente/inicio-cliente';
import { InicioAdmin } from './Administrador/inicio-admin/inicio-admin';
import { InicioEmpleado } from './Empleado/inicio-empleado/inicio-empleado';
import { HeaderAdmin } from './Administrador/header-admin/header-admin';
import { ListaEmpleado } from './Administrador/Empleado/lista-empleado/lista-empleado';
import { CrearEmpleado } from './Administrador/Empleado/crear-empleado/crear-empleado';


export const routes: Routes = [

    //Rutas Compartidas
    {path:"inicio", component: Inicio},
    {path:"login", component: Login},
    {path:'', redirectTo: '/inicio', pathMatch: 'full'},
    {path:'registroCliente', component: RegistroCliente},

    //Rutas Cliente
    {path: 'inicioCliente', component: InicioCliente},

    //Rutas Admin
    {path: 'inicioAdmin', component: InicioAdmin},
    {path: 'headerAdmin', component: HeaderAdmin},
    {path: 'listaEmpleado', component: ListaEmpleado},
    {path:'crearEmpleado', component: CrearEmpleado },

    //Ruta Empleado
    {path: 'inicioEmpleado', component: InicioEmpleado}

];
