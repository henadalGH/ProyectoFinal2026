import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionarEmpleado } from './gestionar-empleado';

describe('GestionarEmpleado', () => {
  let component: GestionarEmpleado;
  let fixture: ComponentFixture<GestionarEmpleado>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionarEmpleado]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionarEmpleado);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
