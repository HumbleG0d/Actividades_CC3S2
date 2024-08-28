const request = require('supertest');
const app = require('../src/app'); 

let server;

beforeAll((done) => {
    server = app.listen(() => {
        console.log(`Server is running on port ${server.address().port}`);
        done();
    });
});

afterAll((done) => {
    server.close(done);
});

describe('GET /', () => {
    it('Should return Hello, World!', async () => {
        const res = await request(app).get('/');
        expect(res.statusCode).toEqual(200);
        expect(res.text).toBe('Hello World');
    });
});
