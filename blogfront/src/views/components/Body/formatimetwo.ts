
/*
 * XXXX年XX月XX日XX时XX分XX秒 【数字格式】
 */

 export const formatTime = (data: Date | string, flag: boolean) => {
  const date = new Date(data);
  const y = date.getFullYear();
  let m: number | string = date.getMonth() + 1;
  m = m < 10 ? '0' + m : m;
  let d: number | string = date.getDate();
  d = d < 10 ? '0' + d : d;
  let h: number | string = date.getHours();
  h = h < 10 ? '0' + h : h;
  let minute: number | string = date.getMinutes();
  minute = minute < 10 ? '0' + minute : minute;
  let second: number | string = date.getSeconds();
  second = second < 10 ? '0' + second : second;
  if (flag) {
    return y + '-' + m + '-' + d;
  }
  return y + '年' + m + '月' + d + '日' + h + '时' + minute + '分' + second + '秒' ;
};

export const format = (data: Date | string) => {
 const date = new Date(data);
 const y = date.getFullYear();
 let m: number | string = date.getMonth() + 1;
 m = m < 10 ? '0' + m : m;
 let d: number | string = date.getDate();
 d = d < 10 ? '0' + d : d;
 let h: number | string = date.getHours();
 h = h < 10 ? '0' + h : h;
 let minute: number | string = date.getMinutes();
 minute = minute < 10 ? '0' + minute : minute;
 let second: number | string = date.getSeconds();
 second = second < 10 ? '0' + second : second;
 return y + '年' + m + '月' + d + '日';
};
