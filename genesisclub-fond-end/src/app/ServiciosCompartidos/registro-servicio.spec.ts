import { TestBed } from '@angular/core/testing';

import { RegistroServicio } from './registro-servicio';

describe('RegistroServicio', () => {
  let service: RegistroServicio;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistroServicio);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
