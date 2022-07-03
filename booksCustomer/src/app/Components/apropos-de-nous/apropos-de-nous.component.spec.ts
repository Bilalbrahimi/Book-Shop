import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AproposDeNousComponent } from './apropos-de-nous.component';

describe('AproposDeNousComponent', () => {
  let component: AproposDeNousComponent;
  let fixture: ComponentFixture<AproposDeNousComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AproposDeNousComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AproposDeNousComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
