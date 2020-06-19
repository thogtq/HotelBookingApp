-- nguoi_dung
INSERT INTO `nguoi_dung` (`USERNAME`, `PASSWORD`, `HO_TEN`, `SDT`, `DIA_CHI`, `NGAY_SINH`, `CMND`, `EMAIL`, `MA_NGUOI_DUNG`, `TOKEN`) VALUES
('test', '$2y$10$qD59m34E7g1/gthGd/vmq.85SHvmGv5qc4up6jRRNn83NUL3NRepK', 'Nguyen Van A', NULL, NULL, NULL, NULL, NULL, '', NULL),
('admin', '$2y$10$jExckHEPTCVO0l3CaMH8l.GrqsG9mfQBblQzWuYQOvtCVCk.KIfMC', 'Quoc Thong', '0123123213', '100 ABC ABC DFFFFF', '1999-04-04', '0242424242', 'thongtran1100@gmail.com', '1', '66724f7870c38ebb8853ba26e8c38676');
-- thanh_pho
INSERT INTO `thanh_pho` (`TEN`, `MA_THANH_PHO`) VALUES ('Hồ Chí Minh', '1'), ('Hà Nội', '2'), ('Đà Nẵng', '3'), ('Vũng Tàu', '4'), ('Đà Lạt', '5');
-- khach_san
INSERT INTO `khach_san` (`MA_KHACH_SAN`, `MA_THANH_PHO`, `TEN_KS`, `DIA_CHI`, `SDT`, `MO_TA`, `GHI_CHU`, `SO_SAO`, `DIEM_DANH_GIA`, `CHINH_SACH`) VALUES ('KS000001', '1', 'Đại Toàn Hotel', '35/1 Hai Bà Trưng Quận 1', '0822556612', 'Đại Toàn Hotel nằm tại trung tâm nhộn nhịp của TP.HCM, khách sạn ba sao nằm trong khu thương mại, mua sắm và vui chơi giải trí. Chỉ cách sân bay quốc tể 30 phút, năm phút đi từ trạm xe buýt, và chợ Bến Thành nổi tiếng, nơi khách có thể trải nghiệm mua sắm thú vị; túi sách, đồ sơn mài, và hàng thủ công mỹ nghệ Việt Nam.', 'Test ghi chú khách sạn', '3', '5.0', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00\r\n'), ('KS000002', '2', 'Hoa Mai Hotel', 'Số 116 Cầu Giấy', '02882424423', 'Hoa Mai Hotel cam kết sẽ đem đến cho bạn một kì nghỉ thoải mái dễ chịu nhất có thể. Khi nghỉ ngơi trong khách sạn tuyệt vời này, khách có thể tận hưởng dịch vụ phòng 24 giờ, miễn phí wifi tất cả các phòng, cửa hàng quà tặng, dịch vụ taxi, quầy lễ tân 24 giờ.\r\n', 'Test ghi chú khách sạn', '4', '7.5', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00\r\n'), ('KS000003', '5', 'Sliver Land Central', '266 Quang Trung', '0523532515', 'Sliver Land Central cam kết sẽ đem đến cho bạn một kì nghỉ thoải mái dễ chịu nhất có thể. Khi nghỉ ngơi trong khách sạn tuyệt vời này, khách có thể tận hưởng dịch vụ phòng 24 giờ, miễn phí wifi tất cả các phòng, cửa hàng quà tặng, dịch vụ taxi, quầy lễ tân 24 giờ.\r\n', 'Test ghi chú khách sạn', '5', '7.0', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00\r\n'), ('KS000004', '4', 'QMQ HomeStay', '66 Nguyễn An Ninh', '0125165165', 'cam kết sẽ đem đến cho bạn một kì nghỉ thoải mái dễ chịu nhất có thể. Khi nghỉ ngơi trong khách sạn tuyệt vời này, khách có thể tận hưởng dịch vụ phòng 24 giờ, miễn phí wifi tất cả các phòng, cửa hàng quà tặng, dịch vụ taxi, quầy lễ tân 24 giờ.\r\n', 'Test ghi chú khách sạn', '4', '8.0', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00\r\n'), ('KS000005', '3', 'Minh Toàn Galaxy Hotel', '352 Nguyễn Văn Linh, Quận Hải Âu', '01215215222', 'Minh Toàn Galaxy Hotel cam kết sẽ đem đến cho bạn một kì nghỉ thoải mái dễ chịu nhất có thể. Khi nghỉ ngơi trong khách sạn tuyệt vời này, khách có thể tận hưởng dịch vụ phòng 24 giờ, miễn phí wifi tất cả các phòng, cửa hàng quà tặng, dịch vụ taxi, quầy lễ tân 24 giờ.\r\n', 'Test ghi chú', '2', '7.5', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00'),('KS000006', '4', 'Sun River Hotel', '155 Đường 30/4', '0125165165', 'Sun River Hotel cam kết sẽ đem đến cho bạn một kì nghỉ thoải mái dễ chịu nhất có thể. Khi nghỉ ngơi trong khách sạn tuyệt vời này, khách có thể tận hưởng dịch vụ phòng 24 giờ, miễn phí wifi tất cả các phòng, cửa hàng quà tặng, dịch vụ taxi, quầy lễ tân 24 giờ.\r\n', 'Test ghi chú khách sạn', '3', '5.0', 'Nhận phòng từ: 14:00\r\nTrả phòng đến: 12:00\r\n');
-- phong
INSERT INTO `phong` (`TEN_PHONG`, `GIA_PHONG`, `DIEN_TICH`, `SUC_CHUA`, `LOAI_GIUONG`, `MA_PHONG`, `MA_KHACH_SAN`) VALUES 
('Phòng Premier Deluxe', '2500000', '38', '8', '2 giường đôi', 'R000001', 'KS000001'),
('Phòng Premier Central', '1500000', '28', '8', '2 giường đôi', 'R000002', 'KS000002'),
('Phòng Suite view sông', '500000', '35', '8', '1 giường đôi', 'R000003', 'KS000003'),
('Phòng Super Deluxe', '3500000', '27', '16', '4 giường đôi', 'R000004', 'KS000004'),
('Phòng Superior', '1200000', '25', '8', '2 giường đôi', 'R000005', 'KS000005'),
('BUNGALOW KING', '900000', '28', '8', '2 giường đôi', 'R000006', 'KS000006'),
('Single room - Premium', '1300000', '29', '4', '1 giường đôi', 'R000007', 'KS000006'),
('Ocean View Luxury', '8900000', '40', '8', '2 giường đôi', 'R000008', 'KS000006');
-- danh_gia
INSERT INTO `danh_gia` (`MA_NGUOI_DUNG`, `MA_KHACH_SAN`, `SO_DIEM`, `NOI_DUNG`) VALUES ('1', 'KS000006', '8', 'khach san tot'), ('', 'KS000006', '7', 'ok');
-- dat_phong
INSERT INTO `dat_phong` (`NGAY_DAT`, `NGAY_DEN`, `NGAY_DI`, `TONG_TIEN`, `TINH_TRANG`, `IS_REVIEW`, `MA_DAT_PHONG`, `MA_NGUOI_DUNG`, `MA_PHONG`) VALUES ('2020-06-19 00:00:00', '2020-06-25', '2020-06-30', '8900000', 'pending', '1', 'DP000001', '1', 'R000008'), ('2020-06-01 00:00:00', '2020-06-02', '2020-06-06', '2500000', 'done', '0', 'DP000002', '1', 'R000001'), ('2020-06-19 00:00:00', '2020-06-20', '2020-06-30', '1300000', 'canceled', '0', 'DP000003', '1', 'R000007');
-- co_so_phong
INSERT INTO `co_so_phong` (`TEN_CO_SO`, `MA_CO_SO`) VALUES ('Điện thoại', 'CS0001'), ('Wifi', 'CS0002'), ('TV', 'CS0003'), ('Két sắt', 'CS0004'), ('Điều hoà', 'CS0010'), ('Tủ lạnh', 'CS0005'), ('Mấy sấy tóc', 'CS0006'), ('Bàn làm việc', 'CS0007'), ('Tủ quần áo', 'CS0008'), ('Ban công', 'CS0009');
--ct_phong
INSERT INTO `ct_phong` (`MA_PHONG`, `MA_CO_SO`, `DON_VI`) VALUES 
('R000001', 'CS0001', NULL),
('R000001', 'CS0002', NULL),
('R000001', 'CS0003', NULL),
('R000001', 'CS0004', NULL),
('R000001', 'CS0005', NULL),
('R000001', 'CS0006', NULL),
('R000001', 'CS0007', NULL),
('R000001', 'CS0008', NULL),
('R000001', 'CS0009', NULL),
('R000001', 'CS0010', NULL),
('R000002', 'CS0001', NULL),
('R000002', 'CS0002', NULL),
('R000002', 'CS0003', NULL),
('R000002', 'CS0004', NULL),
('R000002', 'CS0005', NULL),
('R000002', 'CS0006', NULL),
('R000003', 'CS0001', NULL),
('R000003', 'CS0002', NULL),
('R000003', 'CS0003', NULL),
('R000003', 'CS0004', NULL),
('R000003', 'CS0005', NULL),
('R000003', 'CS0006', NULL),
('R000004', 'CS0001', NULL),
('R000004', 'CS0002', NULL),
('R000004', 'CS0003', NULL),
('R000004', 'CS0004', NULL),
('R000004', 'CS0005', NULL),
('R000005', 'CS0001', NULL),
('R000005', 'CS0002', NULL),
('R000005', 'CS0003', NULL),
('R000005', 'CS0004', NULL),
('R000005', 'CS0005', NULL),
('R000006', 'CS0007', NULL),
('R000006', 'CS0008', NULL),
('R000006', 'CS0009', NULL),
('R000006', 'CS0010', NULL),
('R000007', 'CS0007', NULL),
('R000007', 'CS0008', NULL),
('R000007', 'CS0009', NULL),
('R000007', 'CS0010', NULL),
('R000008', 'CS0007', NULL),
('R000008', 'CS0008', NULL),
('R000008', 'CS0009', NULL),
('R000008', 'CS0010', NULL);