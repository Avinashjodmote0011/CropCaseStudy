import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletecropbyidComponent } from './deletecropbyid.component';

describe('DeletecropbyidComponent', () => {
  let component: DeletecropbyidComponent;
  let fixture: ComponentFixture<DeletecropbyidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeletecropbyidComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeletecropbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
