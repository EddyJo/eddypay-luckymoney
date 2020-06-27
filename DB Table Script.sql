use luckypay;

select * from LUCKY_MONEY;
DROP TABLE LUCKY_MONEY;
CREATE TABLE LUCKY_MONEY
			( seq int(10),
			  user_id VARCHAR(30) not null,
              room_id varchar(30) not null,
              token varchar(3) not null,
              lucky_money_amt bigint(12),
              lucky_money_target_cnt int(4),
              reg_dt varchar(8),
              reg_tm varchar(6),
			  PRIMARY KEY(seq, user_id, room_id)
            );


CREATE TABLE DIVIDED_LUCKY_MONEY
			( seq int(10),
			  user_id VARCHAR(30) not null,
              room_id varchar(30) not null,
              divided_lucky_money bigint(12),
              recv_user_id VARCHAR(30),
              recv_yn VARCHAR(1),
			  recv_dt VARCHAR(8),
              recv_tm VARCHAR(6),
              reg_dt varchar(8),
              reg_tm varchar(6)
            );
