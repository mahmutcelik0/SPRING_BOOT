import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NfIfExampleComponent } from './ng-if-example.component';

describe('NfIfExampleComponent', () => {
  let component: NfIfExampleComponent;
  let fixture: ComponentFixture<NfIfExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NfIfExampleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NfIfExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
