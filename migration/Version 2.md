# Migrating Expenditures to version 2.0.0

Expenditures 2.0 is a major release, focused on upgrading its infrastructure to Bennu 3.1, and upgrading the codebase to Java 8.

In order to migrate your existing application to version 2.0, you must run the following steps:

1. Run the following SQL:

	```sql
	ALTER TABLE FINANCE_SYSTEM CHANGE OID_MY_ORG OID_BENNU bigint unsigned;
	```

