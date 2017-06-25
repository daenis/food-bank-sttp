import { TestBed, getTestBed, async, inject } from '@angular/core/testing';
import { Headers, BaseRequestOptions, Response, HttpModule, Http, XHRBackend, RequestMethod } from '@angular/http';
import { ResponseOptions } from '@angular/http';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { OrderForm } from './orderform';
import { OrderFormService } from './orderform.service';

describe('OrderFormService', () => {
  let mockBackend: MockBackend;
  // This before each set up is uber-important, this took ages to tweak
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [
        OrderFormService,
        MockBackend,
        BaseRequestOptions,
        {
          provide: Http,
          deps: [MockBackend, BaseRequestOptions],
          useFactory:
            (backend: XHRBackend, defaultOptions: BaseRequestOptions) => {
              return new Http(backend, defaultOptions);
            }
       }
      ],
      imports: [
        HttpModule
      ]
    });
    mockBackend = getTestBed().get(MockBackend);
  }));

  it('should get orders', done => {
    let orderFormService: OrderFormService;

    getTestBed().compileComponents().then(() => {
      mockBackend.connections.subscribe(
        (connection: MockConnection) => {
          connection.mockRespond(new Response(
            new ResponseOptions({
                body: [
                  {
                    category: 'Stuff',
                    description: 'Some Good Stuff',
                    quantity: 'Lots of stuff'
                  }]
              }
            )));
        });

        orderFormService = getTestBed().get(OrderFormService);
        expect(OrderFormService).toBeDefined();

        orderFormService.getOrders().subscribe((data) => {
            expect(data.length).toBeDefined();
            expect(data.length).toEqual(1);
            done();
        });
    });
  });

  it('should get orders async',
    async(inject([OrderFormService], (orderFormService) => {
      mockBackend.connections.subscribe(
        (connection: MockConnection) => {
          connection.mockRespond(new Response(
            new ResponseOptions({
                body: [
                  {
                    category: 'Stuff',
                    description: 'Some Good Stuff',
                    quantity: 'Lots of Stuff'
                  }]
              }
            )));
        });

      orderFormService.getOrders().subscribe(
        (data) => {
          expect(data.length).toBe(1);
          expect(data[0].category).toBe("Stuff");
          expect(data[0].quantity).toBe('Lots of Stuff');
      });
    })));

});
