import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParameterizedPipeComponent } from './parameterized-pipe.component';

describe('ParameterizedPipeComponent', () => {
  let component: ParameterizedPipeComponent;
  let fixture: ComponentFixture<ParameterizedPipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParameterizedPipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParameterizedPipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
