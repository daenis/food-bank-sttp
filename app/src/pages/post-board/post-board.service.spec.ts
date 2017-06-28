import { TestBed, getTestBed, async, inject } from '@angular/core/testing';
import { Headers, BaseRequestOptions, Response, HttpModule, Http, XHRBackend, RequestMethod } from '@angular/http';
import { ResponseOptions } from '@angular/http';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { PostBoard } from './post-board';
import { PostBoardService } from './post-board.service';

describe('PostBoardService', () => {
  let mockBackend: MockBackend;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [
        PostBoardService,
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
    let orderFormService: PostBoardService;

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

        orderFormService = getTestBed().get(PostBoardService);
        expect(PostBoardService).toBeDefined();

        orderFormService.getOrders().subscribe((data) => {
            expect(data.length).toBeDefined();
            expect(data.length).toEqual(1);
            done();
        });
    });
  });

  it('should get orders async',
    async(inject([PostBoardService], (orderFormService) => {
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

    it('should delete orders', done => {
    let orderFormService: PostBoardService;

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

        orderFormService = getTestBed().get(PostBoardService);
        expect(PostBoardService).toBeDefined();

        orderFormService.deleteOrder("Stuff").subscribe((data) => {
            expect(data.length).toBeUndefined();
            done();
        });
    });
  });


});
