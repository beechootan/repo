import { TestBed } from '@angular/core/testing';

import { DoctorstatusService } from './doctorstatus.service';

describe('DoctorstatusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DoctorstatusService = TestBed.get(DoctorstatusService);
    expect(service).toBeTruthy();
  });
});
