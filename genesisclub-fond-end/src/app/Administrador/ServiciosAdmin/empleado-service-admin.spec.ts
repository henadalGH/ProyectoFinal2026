import { TestBed } from '@angular/core/testing';

import { EmpleadoServiceAdmin } from './empleado-service-admin';

describe('EmpleadoServiceAdmin', () => {
  let service: EmpleadoServiceAdmin;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmpleadoServiceAdmin);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
