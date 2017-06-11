export class Product {
    constructor(
        public referenceNumber: number,
        public category: string,
        public description: string,
        public price: number,
        public unitMeasure: string
    ){}
}
