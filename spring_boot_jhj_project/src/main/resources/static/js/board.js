/*
 * boardService
 * 모듈 구성하기
 * 
 * 모듈 패턴은 쉽게 말해서 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 객체를 구성한다.
 * 모듈 패턴은 JavaScript의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다.
 * 
 * 
 */

console.log("board Module......");

let boardService = (function () {


	function deleteBoard(id) {
		$.ajax({
			type: "DELETE",
			contentType: 'application/json;charset=utf-8',
			url: "/boards/" + id,
			success: function (result) {
				console.log(result);
			},
			error: function (e) {
				console.log(e);
			}
		});
	}

	function getBoard(id) {
		$.ajax({
			type: "GET",
			url: "/boards/" + id,
			success: function (result) {
				console.log(result);
			},
			error: function (e) {
				console.log(e);
			}
		});
	}

	function makeList(result) {
		let htmls = "";
		$("#table").html("");
		$("<tr>", {
			html: "<td>" + "번호" + "</td>" +
				"<td>" + "작성자" + "</td>" +
				"<td>" + "제목" + "</td>" +
				"<td>" + "작성일" + "</td>" +
				"<td>" + "조회수" + "</td>" +
				"<td>" + "삭제" + "</td>"
		}).appendTo("#table");

		if (result.length < 1) {
			htmls.push("등록된 게시글이 없습니다.");
		} else {
			$(result).each(function () {
				htmls += '<tr>';
				htmls += '<td>' + this.bid + '</td>';
				htmls += '<td>' + this.bname + '</td>';
				htmls += '<td>';
				for (let i = 0; i < this.bindent; i++) {
					htmls += '[re]'
				}
				htmls += '<a href="/board/hit?bid=' + this.bid + '">' + this.btitle + "</a>";
				htmls += '</td>';
				htmls += '<td>' + this.bdate + '</td>';
				htmls += '<td>' + this.bhit + '</td>';
				htmls += '<td><button id="' + this.bid + '">삭제</button></td>';
				htmls += '</tr>';
			});
		}

		htmls += '<tr>';
		htmls += '<td colspan="5"><a href="/board/write_view">글작성</a></td>';
		htmls += '</tr>';
		$("#table").append(htmls);
		$(document).on("click", "button", function () {
			deleteBoard(this.id);
			$(this).parent().parent().remove();
		})
	}



	function boardList() {
		$.ajax({
			type: "GET",
			url: "/boards/list",
			success: function (result) {
				makeList(result)
			},
			error: function (e) {
				console.log(e);
			}
		});

	}

	return {
		list: boardList,
		get: getBoard,
		del: deleteBoard
	}

})();