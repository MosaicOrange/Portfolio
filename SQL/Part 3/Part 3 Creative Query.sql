DECLARE @d AS date = GETDATE()
DECLARE @e AS date = '2000-01-31'

SELECT DISTINCT Account.AccountID,
CONVERT(varchar, Account.AccountBalance, 1) AS 'Account Balance',
--EUR_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT EUR_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT EUR_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT EUR_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT EUR_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT EUR_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT EUR_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'EUR Value Change',
--GBP_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT GBP_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT GBP_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT GBP_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT GBP_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT GBP_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT GBP_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'GBP Value Change',
--CAD_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CAD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT CAD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CAD_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT CAD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CAD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CAD_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'CAD Value Change',
--AUD_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT AUD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT AUD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT AUD_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT AUD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT AUD_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT AUD_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'AUD Value Change',
--JPY_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT JPY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT JPY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT JPY_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT JPY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT JPY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT JPY_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'JPY Value Change',
--CNY_Change
CASE WHEN (AccountOpenDate >= @e) THEN
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CNY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			-
			(SELECT CNY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CNY_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			-
			(SELECT CNY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountOpenDate = Percent_Month_ID OR 
					(Account.AccountOpenDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountOpenDate)<Percent_Month_ID AND
					Account.AccountOpenDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
ELSE
	CASE WHEN (AccountCloseDate IS NOT NULL) THEN
		(CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CNY_Change FROM Exchange_History INNER JOIN Account ON
				(Account.AccountCloseDate = Percent_Month_ID OR 
					(Account.AccountCloseDate != Percent_Month_ID AND
					(DATEADD(m,-1,Account.AccountCloseDate)<Percent_Month_ID AND
					Account.AccountCloseDate>Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1))
	ELSE
		((CONVERT(varchar, (CONVERT(money,(1-(
			(SELECT CNY_Change FROM Exchange_History WHERE
				(@d = Percent_Month_ID OR (@d != Percent_Month_ID
					AND (DATEADD(m,-1,@d)<Percent_Month_ID))))
			)/100)*Account.AccountBalance)), 1)))
	END
END AS 'CNY Value Change'
FROM Exchange_History, Account
ORDER BY AccountID ASC;
