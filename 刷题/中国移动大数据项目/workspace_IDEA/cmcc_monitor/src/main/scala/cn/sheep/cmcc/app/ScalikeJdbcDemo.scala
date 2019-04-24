package cn.sheep.cmcc.app

import scalikejdbc._
import scalikejdbc.config.DBs

/**
  * ZhangJunJie
  * 2018/10/17 17:58
  * Describe：scalikejdbc 访问mysql测试
  **/

case class WordCount(words:String, count:Int)
object ScalikeJdbcDemo {

  def main(args: Array[String]): Unit = {
    // 读取mysql的配置 url-》application.conf -> application.json -> application.properties
    DBs.setup()

//    //查询数据（只读）
//    DB.readOnly{ implicit session =>
//      SQL("select * from wordcount").map(rs => {
////        (
////          rs.string("words"),
////          rs.int(2)
////        )
//        WordCount(rs.string("words"), rs.int(2))
//      }).list().apply()
//    }.foreach(println)

//    //删除数据
//    DB.autoCommit{ implicit session =>
//      SQL("delete from wordcount where words='hadoop'").update().apply()
//    }

    //事务
//    DB.localTx{implicit  session =>
//      SQL("insert into wordcount values(?,?)").bind("net", 10).update().apply()
//      var r = 1 / 0
//      SQL("insert into wordcount values(?,?)").bind("php", 20).update().apply()
//    }

    /**
      * 使用事务插入数据库
      */
//    val tx: Int = DB.localTx{ implicit session =>
//      SQL("insert into wordcount values(?,?)").bind("net", 10).update().apply()
//       var s = 1 / 0
//      SQL("insert into wordcount values(?,?)").bind("php", 20).update().apply()
//    }
//    println(s"tx = ${tx}")

    //在数据插入的时候建立一个事务。
//    def insertBatch() = {
//      DB.localTx { implicit session =>
//        SQL("insert into wordcount values(?,?)").bind("net", 10).update().apply()
//        //val r = 1 / 0
//        SQL("insert into wordcount values(?,?,?)").bind("php", 20,10).update().apply()
//      }
//    }
//
//    insertBatch()


//    implicit val session = DB.readOnlySession()
//    try {
//      val names = sql"select words from wordcount".map { rs => rs.string("words") }.list.apply()
//      names.foreach(println)
//      // do something
//    } finally {
//      session.close()
//    }

//    implicit val session = DB.autoCommitSession()
//    try {
//      sql"insert into wordcount values(?,?)".bind("net", 10).update.apply() // auto-commit
//      sql"insert into wordcount values(?,?)".bind("php", 20).update.apply() // auto-commit
//    } finally { session.close() }

    val count = DB localTx { implicit session =>
      // --- transcation scope start ---
      sql"insert into wordcount values(${"net"},10)".update.apply()
      //var r = 1 / 0
      sql"insert into wordcount values(${"php"}, 20, 20)".update.apply()
        // --- transaction scope end ---
      //  throw new RuntimeException("This transaction will be rolled back")
    }
    println(s"${count}")
  }
}
