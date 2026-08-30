import { DaoInterface } from './daointer';
import { Dao } from './Dao';
import {person} from './persons';


let dao: DaoInterface<person> = new Dao<person>();

dao.insert(new person("John"));
