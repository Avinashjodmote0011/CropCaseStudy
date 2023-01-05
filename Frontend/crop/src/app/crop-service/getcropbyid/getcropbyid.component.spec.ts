import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetcropbyidComponent } from './getcropbyid.component';

describe('GetcropbyidComponent', () => {
  let component: GetcropbyidComponent;
  let fixture: ComponentFixture<GetcropbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetcropbyidComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetcropbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
