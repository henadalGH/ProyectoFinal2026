import { Routes } from '@angular/router';
import { Inicio } from './ComponentesPublico/inicio/inicio';
import { Login } from './ComponentesPublico/login/login';
import { InicioAdmin } from './Administrador/inicio-admin/inicio-admin';
import { HeaderAdmin } from './Administrador/header-admin/header-admin';

export const routes: Routes = [

    //Rutas Compartidas
    {path:"inicio", component: Inicio},
    {path:"login", component: Login},
    {path:'', redirectTo: '/inicio', pathMatch: 'full'},

    //Rutas del administrador
    {path: "inicioAdmin", component: InicioAdmin},
    {path: "headerAdmin", component: HeaderAdmin}
];
