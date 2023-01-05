import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetcropbyuseridComponent } from './getcropbyuserid.component';

describe('GetcropbyuseridComponent', () => {
  let component: GetcropbyuseridComponent;
  let fixture: ComponentFixture<GetcropbyuseridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetcropbyuseridComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetcropbyuseridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
