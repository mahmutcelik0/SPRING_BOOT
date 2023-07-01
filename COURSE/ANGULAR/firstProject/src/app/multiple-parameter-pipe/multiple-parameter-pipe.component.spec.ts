import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MultipleParameterPipeComponent } from './multiple-parameter-pipe.component';

describe('MultipleParameterPipeComponent', () => {
  let component: MultipleParameterPipeComponent;
  let fixture: ComponentFixture<MultipleParameterPipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MultipleParameterPipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MultipleParameterPipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
