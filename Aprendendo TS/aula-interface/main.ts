import { personDao } from './dao/personDao';
import { DaoInterface } from './dao/daointerface';

let personDao: DaoInterface = new personDao();

personDao.insert({ name: "John Doe" });
