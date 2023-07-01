import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetRequestComponentComponent } from './get-request-component.component';

describe('GetRequestComponentComponent', () => {
  let component: GetRequestComponentComponent;
  let fixture: ComponentFixture<GetRequestComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetRequestComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetRequestComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
