
alter table MY_ORG add column KEY_EXPENDITURE_TRACKING_SYSTEM int(11) default NULL;
alter table EXPENDITURE_TRACKING_SYSTEM add column KEY_MY_ORG int(11) default NULL; 
insert into MY_ORG values(1, 1);
update MY_ORG set KEY_EXPENDITURE_TRACKING_SYSTEM = 1;
update EXPENDITURE_TRACKING_SYSTEM set KEY_MY_ORG = 1; 



-- Inserted at 2009-01-27T17:29:25.987Z




create table SAVED_SEARCH (
  `ACQUISITION_PROCESS_STATE_TYPE` text,
  `ID_INTERNAL` int(11) NOT NULL auto_increment,
  `KEY_ACCOUNTING_UNIT` int(11),
  `KEY_EXPENDITURE_TRACKING_SYSTEM` int(11),
  `KEY_PERSON` int(11),
  `KEY_REQUESTOR` int(11),
  `KEY_SUPPLIER` int(11),
  `KEY_UNIT` int(11),
  `PENDING_OPERATIONS` tinyint(1),
  `PROCESS_ID` text,
  `PROPOSAL_ID` text,
  `REFUNDEE_NAME` text,
  `REFUND_PROCESS_STATE_TYPE` text,
  `REQUEST_DOCUMENT_ID` text,
  `SEARCH_CLASS_NAME` text,
  `SEARCH_NAME` text,
  `SHOW_ONLY_ACQUISITIONS_EXCLUDED_FROM_SUPPLIER_LIMIT` tinyint(1),
  `SHOW_ONLY_ACQUISITIONS_WITH_ADDITIONAL_COSTS` tinyint(1),
  `SHOW_ONLY_RESPONSABILITIES` tinyint(1),
  primary key (ID_INTERNAL),
  index (KEY_ACCOUNTING_UNIT),
  index (KEY_EXPENDITURE_TRACKING_SYSTEM),
  index (KEY_PERSON),
  index (KEY_REQUESTOR),
  index (KEY_SUPPLIER),
  index (KEY_UNIT)
) type=InnoDB ;




-- Inserted at 2009-01-27T19:24:41.518Z

alter table PERSON add column KEY_DEFAULT_SEARCH int(11);
alter table PERSON add index (KEY_DEFAULT_SEARCH);





-- Inserted at 2009-01-27T19:29:46.377Z

alter table SAVED_SEARCH add column KEY_EXPENDITURE_TRACKING_SYSTEM_FOR_SYSTEM_SEARCH int(11);
alter table SAVED_SEARCH add index (KEY_EXPENDITURE_TRACKING_SYSTEM_FOR_SYSTEM_SEARCH);

-- Inserted at 2009-01-28T15:06:13.667Z

alter table PERSON add column LOGOUT_DATE_TIME timestamp NULL default NULL;




-- Inserted at 2009-01-28T15:13:48.607Z

create table FILE_CONTENT (
  `CONTENT` longblob,
  `ID_INTERNAL` int(11) NOT NULL auto_increment,
  `KEY_EXPENDITURE_TRACKING_SYSTEM` int(11),
  `KEY_FILE` int(11),
  primary key (ID_INTERNAL),
  index (KEY_EXPENDITURE_TRACKING_SYSTEM),
  index (KEY_FILE)
) type=InnoDB ;

insert into FILE_CONTENT (ID_INTERNAL, KEY_EXPENDITURE_TRACKING_SYSTEM, KEY_FILE, CONTENT) select ID_INTERNAL, KEY_EXPENDITURE_TRACKING_SYSTEM, ID_INTERNAL, CONTENT from FILE;

alter table FILE add column KEY_FILE_CONTENT int(11);
alter table FILE add index (KEY_FILE_CONTENT);

update FILE set KEY_FILE_CONTENT = ID_INTERNAL;




-- Inserted at 2009-01-28T15:11:58.931Z

alter table SAVED_SEARCH add column OJB_CONCRETE_CLASS text;





-- Inserted at 2009-02-03T12:51:50.848Z

alter table PERSON add column EMAIL text;


-- Inserted at 2009-02-12T17:04:13.674Z

alter table SUPPLIER add column SUPPLIER_LIMIT text;
update SUPPLIER set SUPPLIER_LIMIT = 'EUR:60000.00';

