// Service: Logic FE
// NOI CHUYEN DOI JSON -> LIST
// http://localhost:8080/api/category-management
// => LIST => HIEN THI LEN TABLE
// [
//     {

//     }
// ]
// Tach duong dan chung cua API
const API = "http://localhost:8080/api/category-management";

// liet ke cac api: export = public
// arrow function: =>
// export function test (id){
// }
// export const test = (id)=>{
//     // noi dung ham
// }
// export function get1(){
// }

// GET => HIEN THI DU LIEU: async ... await
export const getCategories = async () => {
  // fetch:
  //  THS1: API(Duong dan =>BE),
  //  THS2: LOAI HTTP METHOD
  // default http method: GET
  //   const res = await fetch(API, {
  //     method: "GET",
  //   });
  const res = await fetch(API);
  if (!res.ok) throw new Error("Load du lieu bi loi");
  return await res.json();
};

// GET => DETAIL
export const detailCategory = async (id10) => {
  // C1: Path variable
  // http://localhost:8080/api/category-management/{{id1}}
  //   const res = await fetch(`${API}/${id10}`);
  // C2: Request param: tren duong dan xuat hien dau ?
  // http://localhost:8080/api/category-management/detail?id2=...
  const res = await fetch(`${API}/detail?id2=${id10}`);
  if (!res.ok) throw new Error("Load du lieu bi loi");
  return await res.json();
};

// DELETE => DELETE
// Khong phai ham nao cung return (BE)
export const deleteCategory = async (id) => {
  const res = await fetch(`${API}/remove/${id}`, {
    method: "DELETE",
  });
  if (!res.ok) {
    const error = await res.text();
    throw new Error("Load du lieu bi loi" + error);
  }
};

// ADD => POST
export const addCategory = async (data) => {
  const res = await fetch(`${API}/add`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) {
    const error = await res.text();
    throw new Error("Load du lieu bi loi" + error);
  }
};

// Update => PUT
export const updateCategory = async (data, id) => {
  const res = await fetch(`${API}/update/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) {
    const error = await res.text();
    throw new Error("Load du lieu bi loi" + error);
  }
};
