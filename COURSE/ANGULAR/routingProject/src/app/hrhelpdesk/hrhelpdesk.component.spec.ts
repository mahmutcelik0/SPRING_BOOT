import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrhelpdeskComponent } from './hrhelpdesk.component';

describe('HrhelpdeskComponent', () => {
  let component: HrhelpdeskComponent;
  let fixture: ComponentFixture<HrhelpdeskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HrhelpdeskComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HrhelpdeskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
